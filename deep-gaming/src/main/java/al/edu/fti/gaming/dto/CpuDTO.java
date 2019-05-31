package al.edu.fti.gaming.dto;

public class CpuDTO extends ProductDTO {

	private Double cpuSpeed;

	private Double turboSpeed;

	private Byte physicalCores;

	private Byte threads;

	private Integer tdp;

	private Integer bitWidth;

	private Integer l1Cache;

	private Integer l2Cache;

	private Integer l3Cache;

	private CpuFamilyDTO familyOfThisCpu;

	private CpuSocketDTO socketOfThisCpu;

	private CpuArchitectureDTO architectureOfThisCpu;

	private GpuDTO integratedGpuOfThisCpu;

	public CpuDTO() {
		super();
	}

	public Double getCpuSpeed() {
		return cpuSpeed;
	}

	public void setCpuSpeed(Double cpuSpeed) {
		this.cpuSpeed = cpuSpeed;
	}

	public Double getTurboSpeed() {
		return turboSpeed;
	}

	public void setTurboSpeed(Double turboSpeed) {
		this.turboSpeed = turboSpeed;
	}

	public Byte getPhysicalCores() {
		return physicalCores;
	}

	public void setPhysicalCores(Byte physicalCores) {
		this.physicalCores = physicalCores;
	}

	public Byte getThreads() {
		return threads;
	}

	public void setThreads(Byte threads) {
		this.threads = threads;
	}

	public Integer getTdp() {
		return tdp;
	}

	public void setTdp(Integer tdp) {
		this.tdp = tdp;
	}

	public Integer getBitWidth() {
		return bitWidth;
	}

	public void setBitWidth(Integer bitWidth) {
		this.bitWidth = bitWidth;
	}

	public Integer getL1Cache() {
		return l1Cache;
	}

	public void setL1Cache(Integer l1Cache) {
		this.l1Cache = l1Cache;
	}

	public Integer getL2Cache() {
		return l2Cache;
	}

	public void setL2Cache(Integer l2Cache) {
		this.l2Cache = l2Cache;
	}

	public Integer getL3Cache() {
		return l3Cache;
	}

	public void setL3Cache(Integer l3Cache) {
		this.l3Cache = l3Cache;
	}

	public CpuFamilyDTO getFamilyOfThisCpu() {
		return familyOfThisCpu;
	}

	public void setFamilyOfThisCpu(CpuFamilyDTO familyOfThisCpu) {
		this.familyOfThisCpu = familyOfThisCpu;
	}

	public CpuSocketDTO getSocketOfThisCpu() {
		return socketOfThisCpu;
	}

	public void setSocketOfThisCpu(CpuSocketDTO socketOfThisCpu) {
		this.socketOfThisCpu = socketOfThisCpu;
	}

	public CpuArchitectureDTO getArchitectureOfThisCpu() {
		return architectureOfThisCpu;
	}

	public void setArchitectureOfThisCpu(CpuArchitectureDTO architectureOfThisCpu) {
		this.architectureOfThisCpu = architectureOfThisCpu;
	}

	public GpuDTO getIntegratedGpuOfThisCpu() {
		return integratedGpuOfThisCpu;
	}

	public void setIntegratedGpuOfThisCpu(GpuDTO integratedGpuOfThisCpu) {
		this.integratedGpuOfThisCpu = integratedGpuOfThisCpu;
	}

}
