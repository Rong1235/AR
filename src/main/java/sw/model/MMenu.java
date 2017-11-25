package sw.model;

import java.util.List;

import sw.entity.Menu;
import lombok.Data;

@Data
public class MMenu {
	private int id;
	private String name;
	private String href;
	private List<MMenu> children;
	public MMenu(Menu menu){
		this.id = menu.getId();
		this.name = menu.getName();
		this.href = menu.getHref();
	}
}
