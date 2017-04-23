package com.gv.archive.compression.implementations;

import com.gv.archive.compression.interfaces.Compressor;
import com.gv.archive.logging.AppLogger;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.Deflater;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class ZipCompressor implements Compressor{

    @Override
    /**
     * compress specified file into archive according specified archive path
     * @param filePath - path to the file
     * @param archivePath - path to the archive
     * @return true - compress was successful
     *         false - compress was unsuccessful
     */
    public boolean compress(String filePath, String archivePath) {
        boolean isCompressed = true;
        try {
            File archive = new File(archivePath);
            if (archive.exists()) {
                archive.delete();
            }
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(archivePath));
            out.setLevel(Deflater.DEFAULT_COMPRESSION);
            File file = new File(filePath);
            if (file.exists()) {
                out.putNextEntry(new ZipEntry(file.getPath()));
                write(new FileInputStream(file), out);
            }
            out.close();
        } catch (Exception e) {
            AppLogger.getLogger().error(e);
            isCompressed = false;
        } finally {
            return isCompressed;
        }
    }

    @Override
    /**
     * extracts all files from specified archive
     * @param archivePath - path to archive
     * @return true - decompress was successful
     *         false - decompress was unsuccessful
     */
    public boolean decompress(String archivePath) {
        boolean isDecompressed = true;
        File file = new File(archivePath);
        if (!file.exists() || !file.canRead()) {
            System.out.println("File cannot be read");
            return false;
        }
        try {
            ZipFile zip = new ZipFile(archivePath);
            Enumeration entries = zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry)entries.nextElement();
                AppLogger.getLogger().info(entry.getName());
                if (entry.isDirectory()) {
                    new File(file.getParent(), entry.getName()).mkdirs();
                } else {
                    write(zip.getInputStream(entry), new BufferedOutputStream(
                            new FileOutputStream( new File(file.getParent(), entry.getName()))));
                }
            }
            zip.close();
        } catch (IOException e) {
            AppLogger.getLogger().error(e);
            isDecompressed = false;
        } finally {
            return isDecompressed;
        }
    }

    /**
     * private method for write into zip archive
     * @param inputStream input stream of file for zipping
     * @param outputStream output stream of open zip archive
     * @throws IOException error with write/read from this streams
     */
    private static void write(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) >= 0)
            outputStream.write(buffer, 0, length);
        inputStream.close();
    }
}
