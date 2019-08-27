package al.edu.fti.gaming.dao;

import java.util.List;

import al.edu.fti.gaming.models.DirectX;

public interface DirectXRepository {

	int add(DirectX directX);
	
	List<DirectX> getAllDirectXs();
	
	DirectX getDirectXById(int id);
	
	boolean update(DirectX directX);
}
