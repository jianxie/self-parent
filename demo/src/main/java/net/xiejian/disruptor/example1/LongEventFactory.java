package net.xiejian.disruptor.example1;

import com.lmax.disruptor.EventFactory;

/**
 * 定义事件工厂
 * @author jian_xie
 * @date 2015年10月30日
 */
public class LongEventFactory implements EventFactory<LongEvent> {

	public LongEvent newInstance() {
		return new LongEvent();
	}

}
