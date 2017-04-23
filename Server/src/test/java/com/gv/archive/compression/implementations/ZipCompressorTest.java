package com.gv.archive.compression.implementations;

import com.gv.archive.compression.interfaces.Compressor;
import org.junit.Assert;
import org.junit.Test;

public class ZipCompressorTest {

    private Compressor compressor = new ZipCompressor();

    private final static String directoryPath = "/test";

    private final static String filePath = "../Server/test/file.txt";

    private final static String archivePath = "../Server/test/archive.zip";

    @Test
    public void compress() throws Exception {
//        File file = new File("../Server/test");
//        if(file.exists()){
//            for(File f: file.listFiles()){
//                System.out.println(f.getName());
//            }
//        }
          Assert.assertTrue(compressor.compress(filePath, archivePath));
    }

    @Test
    public void decompress() throws Exception {
        Assert.assertTrue(compressor.decompress(archivePath));
    }

}