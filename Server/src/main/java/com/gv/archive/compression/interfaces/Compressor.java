package com.gv.archive.compression.interfaces;

/**
 * Defines contract for compressing and decompressing
 */
public interface Compressor {

    /**
     * compress specified file into archive according specified archive path
     * @param filePath - path to the file
     * @param archivePath - path to the archive
     * @return true - compress was successful
     *         false - compress was unsuccessful
     */
    boolean compress(String filePath, String archivePath);

    /**
     * extracts all files from specified archive
     * @param archivePath - path to archive
     * @return true - decompress was successful
     *         false - decompress was unsuccessful
     */
    boolean decompress(String archivePath);
}
