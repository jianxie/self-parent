package net.xiejian.NIO.base;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 文件读写
 * @author jian_xie
 * @date 2017年10月18日
 */
public class FileBuffer {

	public static void main(String[] args) throws IOException {
		// 打开一个文件
		RandomAccessFile aFile = new RandomAccessFile("F:/data/nio-data.txt", "rw");
		FileChannel inChannel = aFile.getChannel();
		// 设置缓冲区大小，48字节
		ByteBuffer buf = ByteBuffer.allocate(48);
		int bytesRead = inChannel.read(buf);
		while(bytesRead != -1){
			// 把buffer从写模式切换到读模式
			buf.flip();
			while(buf.hasRemaining()){
				System.out.println(buf.getChar());
			}
			// 清空数据
			buf.clear();
			bytesRead = inChannel.read(buf);
		}
		aFile.close();
		ByteBuffer header = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArray = {header, body};
		// 把消息读入多个buffer,第一个写满了才会第二个，适合定长消息。
		inChannel.read(bufferArray);
		// 把多个buffer写入channel 只有position和limit之间的数据才会被写入
		inChannel.write(bufferArray);
	}
	
	private static void test(){
		ByteBuffer header = ByteBuffer.allocate(128);
		ByteBuffer body = ByteBuffer.allocate(1024);
		ByteBuffer[] bufferArray = {header, body};
	}

}
