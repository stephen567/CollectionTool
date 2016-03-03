package com.colletionUtils.Message.Login;

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
 * 登录类消息，默认不做持久化
 */
@Entity
@Table(name = "t_msg")
@DiscriminatorValue("LoginMsg")
public class LoginMsg extends BaseMsg {

	private static final long serialVersionUID = 1L;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = LoginMsg.class)
	@JoinColumn(name = "login_id", nullable = true, updatable = false) // 指定一个外键，也可以不指定。
	private LoginParam loginParam;

	public LoginParam getLoginParam() {
		return loginParam;
	}

	public void setLoginParam(LoginParam loginParam) {
		this.loginParam = loginParam;
	}

	public LoginMsg(String clientId, LoginParam loginParam) {
		setClientId(clientId);
		setMsgType(MsgType.LOGIN);
		setLoginParam(loginParam);
		setPersist(false);
	}

	public LoginMsg(String clientId, LoginParam loginParam, Boolean persist) {
		setClientId(clientId);
		setMsgType(MsgType.LOGIN);
		setLoginParam(loginParam);
		setPersist(persist);
	}

}
