package sw.service;

import java.util.List;
import java.util.Map;

import sw.model.MMenu;

public interface ILeftMenuService {

	
	
	/**
	 * 通过父节点查找所有节点
	 * @param root
	 */
	public MMenu findMenuByRoot(Integer root);
	
	public int addMenu();
	
	
}
