package com.wxad.silence.exception;

/**
 * �������쳣
 * @author <a href="xuzhenqin@gmail.com">Calvin Pang</a>
 *
 */
public class ParserException extends Exception {
	private static final long serialVersionUID = -8034914169899290165L;

	public ParserException() {
		super();
	}

	public ParserException(String message, Throwable cause) {
		super(message, cause);
	}

	public ParserException(String message) {
		super(message);
	}

	public ParserException(Throwable cause) {
		super(cause);
	}
}
