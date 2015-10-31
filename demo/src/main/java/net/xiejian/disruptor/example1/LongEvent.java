package net.xiejian.disruptor.example1;

/**
 * 定义事件
 * @author jian_xie
 * @date 2015年10月30日
 */
public class LongEvent {
	
	private long value;

	public void setValue(long value) {
		this.value = value;
	}
	
	public long getValue(){
		return this.value;
	}
}
