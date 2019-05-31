
package al.edu.fti.gaming.dto;

public class GpuDTO extends ProductDTO {

	private Integer tmu;

	private Integer textureRate;

	private Integer rop;

	private Integer pixelRate;

	private Integer shaderProcessingUnits;

	private Integer rayTracingCores;

	private Integer tensorCores;

	private Double driverSupport;

	private Integer memorySize;

	private Integer memorySpeed;

	private Integer memoryBandwidth;

	private Integer cache;

	private Integer coreSpeed;

	private Integer boostClock;

	private Integer tdp;

	private Double shader;

	private Double openGL;

	private GpuFamilyDTO familyOfThisGpu;

	private GpuArchitectureDTO architectureOfThisGpu;

	private GpuMemoryTechnologyDTO memoryTechnologyOfThisGpu;

	private DirectXDTO maximumDirectXSupportedByThisGpu;

	private GpuSlotDTO gpuSlotOfThisGpu;

	private CpuDTO cpuRecommendedForThisGpu;

	public GpuDTO() {
		super();
	}

	public Integer getTmu() {
		return tmu;
	}

	public void setTmu(Integer tmu) {
		this.tmu = tmu;
	}

	public Integer getTextureRate() {
		return textureRate;
	}

	public void setTextureRate(Integer textureRate) {
		this.textureRate = textureRate;
	}

	public Integer getRop() {
		return rop;
	}

	public void setRop(Integer rop) {
		this.rop = rop;
	}

	public Integer getPixelRate() {
		return pixelRate;
	}

	public void setPixelRate(Integer pixelRate) {
		this.pixelRate = pixelRate;
	}

	public Integer getShaderProcessingUnits() {
		return shaderProcessingUnits;
	}

	public void setShaderProcessingUnits(Integer shaderProcessingUnits) {
		this.shaderProcessingUnits = shaderProcessingUnits;
	}

	public Integer getRayTracingCores() {
		return rayTracingCores;
	}

	public void setRayTracingCores(Integer rayTracingCores) {
		this.rayTracingCores = rayTracingCores;
	}

	public Integer getTensorCores() {
		return tensorCores;
	}

	public void setTensorCores(Integer tensorCores) {
		this.tensorCores = tensorCores;
	}

	public Double getDriverSupport() {
		return driverSupport;
	}

	public void setDriverSupport(Double driverSupport) {
		this.driverSupport = driverSupport;
	}

	public Integer getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(Integer memorySize) {
		this.memorySize = memorySize;
	}

	public Integer getMemorySpeed() {
		return memorySpeed;
	}

	public void setMemorySpeed(Integer memorySpeed) {
		this.memorySpeed = memorySpeed;
	}

	public Integer getMemoryBandwidth() {
		return memoryBandwidth;
	}

	public void setMemoryBandwidth(Integer memoryBandwidth) {
		this.memoryBandwidth = memoryBandwidth;
	}

	public Integer getCache() {
		return cache;
	}

	public void setCache(Integer cache) {
		this.cache = cache;
	}

	public Integer getCoreSpeed() {
		return coreSpeed;
	}

	public void setCoreSpeed(Integer coreSpeed) {
		this.coreSpeed = coreSpeed;
	}

	public Integer getBoostClock() {
		return boostClock;
	}

	public void setBoostClock(Integer boostClock) {
		this.boostClock = boostClock;
	}

	public Integer getTdp() {
		return tdp;
	}

	public void setTdp(Integer tdp) {
		this.tdp = tdp;
	}

	public Double getShader() {
		return shader;
	}

	public void setShader(Double shader) {
		this.shader = shader;
	}

	public Double getOpenGL() {
		return openGL;
	}

	public void setOpenGL(Double openGL) {
		this.openGL = openGL;
	}

	public GpuFamilyDTO getFamilyOfThisGpu() {
		return familyOfThisGpu;
	}

	public void setFamilyOfThisGpu(GpuFamilyDTO familyOfThisGpu) {
		this.familyOfThisGpu = familyOfThisGpu;
	}

	public GpuArchitectureDTO getArchitectureOfThisGpu() {
		return architectureOfThisGpu;
	}

	public void setArchitectureOfThisGpu(GpuArchitectureDTO architectureOfThisGpu) {
		this.architectureOfThisGpu = architectureOfThisGpu;
	}

	public GpuMemoryTechnologyDTO getMemoryTechnologyOfThisGpu() {
		return memoryTechnologyOfThisGpu;
	}

	public void setMemoryTechnologyOfThisGpu(GpuMemoryTechnologyDTO memoryTechnologyOfThisGpu) {
		this.memoryTechnologyOfThisGpu = memoryTechnologyOfThisGpu;
	}

	public DirectXDTO getMaximumDirectXSupportedByThisGpu() {
		return maximumDirectXSupportedByThisGpu;
	}

	public void setMaximumDirectXSupportedByThisGpu(DirectXDTO maximumDirectXSupportedByThisGpu) {
		this.maximumDirectXSupportedByThisGpu = maximumDirectXSupportedByThisGpu;
	}

	public GpuSlotDTO getGpuSlotOfThisGpu() {
		return gpuSlotOfThisGpu;
	}

	public void setGpuSlotOfThisGpu(GpuSlotDTO gpuSlotOfThisGpu) {
		this.gpuSlotOfThisGpu = gpuSlotOfThisGpu;
	}

	public CpuDTO getCpuRecommendedForThisGpu() {
		return cpuRecommendedForThisGpu;
	}

	public void setCpuRecommendedForThisGpu(CpuDTO cpuRecommendedForThisGpu) {
		this.cpuRecommendedForThisGpu = cpuRecommendedForThisGpu;
	}

}
