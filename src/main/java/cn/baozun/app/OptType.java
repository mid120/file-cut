package cn.baozun.app;

public enum OptType {
	JOIN("join", "合并"), CUT("cut", "切割");
	private String code;
	private String msg;

	private OptType(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
