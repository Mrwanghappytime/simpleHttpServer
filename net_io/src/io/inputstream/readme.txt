1.IO流的分类{输入流，输出流}{字节流，字符流}{节点流，处理流}
输入流有两大接口inputstream reader
输出流有outputstream writer

这里讨论InputStream(字节输入流)
                            InputSteam
                                |
   ByteArrayInputStream      PipedInputStream    FilterInputStream  FileInputStream   ObjectInputStream
                                                         |
                                                         |
                                                BufferedInputStream DataInputStream

                                                        这两者为处理流，其余都为节点流

