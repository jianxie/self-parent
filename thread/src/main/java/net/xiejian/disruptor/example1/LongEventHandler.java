package net.xiejian.disruptor.example1;

import com.lmax.disruptor.EventHandler;

/**
 * 定义事件处理的具体实现
 * @author jian_xie
 * @date 2015年10月30日
 */
public class LongEventHandler implements EventHandler<LongEvent> {

	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("Event:" + event);
	}

}
