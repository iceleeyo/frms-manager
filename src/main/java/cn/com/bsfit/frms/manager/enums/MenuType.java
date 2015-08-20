package cn.com.bsfit.frms.manager.enums;

/**
 * 菜单类型
 * 
 * @author hjp
 * 
 * @since 1.0.0
 *
 */
public enum MenuType {
	
	NOTMENU((short) 0, "非菜单"), ISMENU((short) 1, "是菜单");
	private Short index;
	private String name;
	
	private MenuType(Short index, String name) {
		this.index = index;
		this.name = name;
	}

	public Short getIndex() {
		return index;
	}

	public void setIndex(Short index) {
		this.index = index;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getNameByIndex(Short index) {
		for(MenuType type : MenuType.values()) {
			if (type.getIndex().equals(index)) {
				return type.getName();
			}
		}
		return null;
	}
}
