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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((architectureOfThisCpu == null) ? 0 : architectureOfThisCpu.hashCode());
		result = prime * result + ((bitWidth == null) ? 0 : bitWidth.hashCode());
		result = prime * result + ((cpuSpeed == null) ? 0 : cpuSpeed.hashCode());
		result = prime * result + ((familyOfThisCpu == null) ? 0 : familyOfThisCpu.hashCode());
		result = prime * result + ((integratedGpuOfThisCpu == null) ? 0 : integratedGpuOfThisCpu.hashCode());
		result = prime * result + ((l1Cache == null) ? 0 : l1Cache.hashCode());
		result = prime * result + ((l2Cache == null) ? 0 : l2Cache.hashCode());
		result = prime * result + ((l3Cache == null) ? 0 : l3Cache.hashCode());
		result = prime * result + ((physicalCores == null) ? 0 : physicalCores.hashCode());
		result = prime * result + ((socketOfThisCpu == null) ? 0 : socketOfThisCpu.hashCode());
		result = prime * result + ((tdp == null) ? 0 : tdp.hashCode());
		result = prime * result + ((threads == null) ? 0 : threads.hashCode());
		result = prime * result + ((turboSpeed == null) ? 0 : turboSpeed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CpuDTO other = (CpuDTO) obj;
		if (architectureOfThisCpu == null) {
			if (other.architectureOfThisCpu != null)
				return false;
		} else if (!architectureOfThisCpu.equals(other.architectureOfThisCpu))
			return false;
		if (bitWidth == null) {
			if (other.bitWidth != null)
				return false;
		} else if (!bitWidth.equals(other.bitWidth))
			return false;
		if (cpuSpeed == null) {
			if (other.cpuSpeed != null)
				return false;
		} else if (!cpuSpeed.equals(other.cpuSpeed))
			return false;
		if (familyOfThisCpu == null) {
			if (other.familyOfThisCpu != null)
				return false;
		} else if (!familyOfThisCpu.equals(other.familyOfThisCpu))
			return false;
		if (integratedGpuOfThisCpu == null) {
			if (other.integratedGpuOfThisCpu != null)
				return false;
		} else if (!integratedGpuOfThisCpu.equals(other.integratedGpuOfThisCpu))
			return false;
		if (l1Cache == null) {
			if (other.l1Cache != null)
				return false;
		} else if (!l1Cache.equals(other.l1Cache))
			return false;
		if (l2Cache == null) {
			if (other.l2Cache != null)
				return false;
		} else if (!l2Cache.equals(other.l2Cache))
			return false;
		if (l3Cache == null) {
			if (other.l3Cache != null)
				return false;
		} else if (!l3Cache.equals(other.l3Cache))
			return false;
		if (physicalCores == null) {
			if (other.physicalCores != null)
				return false;
		} else if (!physicalCores.equals(other.physicalCores))
			return false;
		if (socketOfThisCpu == null) {
			if (other.socketOfThisCpu != null)
				return false;
		} else if (!socketOfThisCpu.equals(other.socketOfThisCpu))
			return false;
		if (tdp == null) {
			if (other.tdp != null)
				return false;
		} else if (!tdp.equals(other.tdp))
			return false;
		if (threads == null) {
			if (other.threads != null)
				return false;
		} else if (!threads.equals(other.threads))
			return false;
		if (turboSpeed == null) {
			if (other.turboSpeed != null)
				return false;
		} else if (!turboSpeed.equals(other.turboSpeed))
			return false;
		return true;
	}
	
	

}
