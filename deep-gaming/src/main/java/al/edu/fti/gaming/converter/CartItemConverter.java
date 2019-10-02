package al.edu.fti.gaming.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import al.edu.fti.gaming.dto.CartDTO;
import al.edu.fti.gaming.dto.CartItemDTO;
import al.edu.fti.gaming.dto.IDto;
import al.edu.fti.gaming.dto.ProductDTO;
import al.edu.fti.gaming.dto.ProductTypeDTO;
import al.edu.fti.gaming.models.CPU;
import al.edu.fti.gaming.models.Cart;
import al.edu.fti.gaming.models.CartItem;
import al.edu.fti.gaming.models.GPU;
import al.edu.fti.gaming.models.Game;
import al.edu.fti.gaming.models.IModel;
import al.edu.fti.gaming.models.Motherboard;
import al.edu.fti.gaming.models.Product;
import al.edu.fti.gaming.service.CpuService;
import al.edu.fti.gaming.service.GameService;
import al.edu.fti.gaming.service.GpuService;
import al.edu.fti.gaming.service.MotherboardService;

@Component
public class CartItemConverter implements Converter {

	@Autowired
	private CpuService cpuService;

	@Autowired
	private GpuService gpuService;

	@Autowired
	private GameService gameService;

	@Autowired
	private MotherboardService motherboardService;

	@Autowired
	@Qualifier("cpuConverter")
	private Converter cpuConverter;

	@Autowired
	@Qualifier("gpuConverter")
	private Converter gpuConverter;

	@Autowired
	@Qualifier("motherboardConverter")
	private Converter motherboardConverter;

	@Autowired
	@Qualifier("gameConverter")
	private Converter gameConverter;

	@Autowired
	@Qualifier("cartConverter")
	private Converter cartConverter;

	@Autowired
	@Qualifier("productConverter")
	private Converter productConverter;

	@Override
	public IModel toModel(IDto dtoObject) {
		CartItem cartItem = new CartItem();
		CartItemDTO cartItemDTO = (CartItemDTO) dtoObject;
		if (cartItemDTO.getId() != null) {
			cartItem.setId(cartItemDTO.getId());
		}
		cartItem.setQuantity(cartItemDTO.getQuantity());
		cartItem.setProduct((Product) productConverter.toModel(cartItemDTO.getProduct()));

//		String productTypeOfTheProduct = cartItemDTO.getProduct().getProductType().getProductType();

//		if(productTypeOfTheProduct.equals("CPU")) {
//			cartItem.setProduct((CPU) cpuConverter.toModel(cpuService.getCpuById(cartItemDTO.getProduct().getId())));
//		} else if(productTypeOfTheProduct.equals("GPU")) {
//			cartItem.setProduct((GPU) gpuConverter.toModel(gpuService.getGpuById(cartItemDTO.getProduct().getId())));
//		} else if(productTypeOfTheProduct.equals("Motherboard")) {
//			cartItem.setProduct((Motherboard) motherboardConverter.toModel(motherboardService.getMotherboardById(cartItemDTO.getProduct().getId())));
//		} else if(productTypeOfTheProduct.equals("Game")) {
//			cartItem.setProduct((Game) gameConverter.toModel(gameService.getGameById(cartItemDTO.getProduct().getId())));
//		}

		cartItem.setCart((Cart) cartConverter.toModel(cartItemDTO.getIdCart()));
		return cartItem;

	}

	@Override
	public IDto toDTO(IModel modelObject) {
		CartItem cartItem = (CartItem) modelObject;
		CartItemDTO cartItemDTO = new CartItemDTO();
		cartItemDTO.setId(cartItem.getId());
		cartItemDTO.setQuantity(cartItem.getQuantity());
		cartItemDTO.setIdCart((CartDTO) cartConverter.toDTO(cartItem.getCart()));
		cartItemDTO.setProduct((ProductDTO) productConverter.toDTO(cartItem.getProduct()));

//		String productTypeOfTheProduct = cartItem.getProduct().getProductType().getProductType();
//		if(productTypeOfTheProduct.equals("CPU")) {
//			cartItemDTO.setProduct(cpuService.getCpuById(cartItem.getProduct().getIdProduct()));
//		} else if(productTypeOfTheProduct.equals("GPU")) {
//			cartItemDTO.setProduct(gpuService.getGpuById(cartItem.getProduct().getIdProduct()));
//		} else if(productTypeOfTheProduct.equals("Motherboard")) {
//			cartItemDTO.setProduct(motherboardService.getMotherboardById(cartItem.getProduct().getIdProduct()));
//		} else if(productTypeOfTheProduct.equals("Game")) {
//			cartItemDTO.setProduct(gameService.getGameById(cartItem.getProduct().getIdProduct()));
//		}
		return cartItemDTO;
	}

}
