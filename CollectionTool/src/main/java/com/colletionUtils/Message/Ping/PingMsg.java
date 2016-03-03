package com.colletionUtils.Message.Ping;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.colletionUtils.Message.BaseMsg;
import com.colletionUtils.Message.MsgType;

/**
 * 心跳类消息，默认不做持久化
 */
@Entity
@Table(name = "t_msg")
@DiscriminatorValue("PingMsg")
public class PingMsg extends BaseMsg {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = PingParam.class)
	@JoinColumn(name = "ping_id", nullable = true, updatable = false) // 指定一个外键，也可以不指定。
	private PingParam pingParam;

	public PingParam getPingParam() {
		return pingParam;
	}

	public void setPingParam(PingParam pingParam) {
		this.pingParam = pingParam;
	}

	public PingMsg(String clientId) {
		setClientId(clientId);
		setMsgType(MsgType.PING);
		setPingParam(new PingParam(clientId));
		setPersist(false);
	}

	public PingMsg(String clientId, Boolean persist) {
		setClientId(clientId);
		setMsgType(MsgType.PING);
		setPingParam(new PingParam(clientId));
		setPersist(persist);
	}

}
