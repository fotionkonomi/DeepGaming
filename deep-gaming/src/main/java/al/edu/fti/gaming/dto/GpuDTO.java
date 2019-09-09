
package al.edu.fti.gaming.dto;

import java.io.Serializable;

public class GpuDTO extends ProductDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8070710386716560546L;

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
	
	private Integer memoryBus;

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

	public Integer getMemoryBus() {
		return memoryBus;
	}

	public void setMemoryBus(Integer memoryBus) {
		this.memoryBus = memoryBus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((architectureOfThisGpu == null) ? 0 : architectureOfThisGpu.hashCode());
		result = prime * result + ((boostClock == null) ? 0 : boostClock.hashCode());
		result = prime * result + ((cache == null) ? 0 : cache.hashCode());
		result = prime * result + ((coreSpeed == null) ? 0 : coreSpeed.hashCode());
		result = prime * result + ((cpuRecommendedForThisGpu == null) ? 0 : cpuRecommendedForThisGpu.hashCode());
		result = prime * result + ((driverSupport == null) ? 0 : driverSupport.hashCode());
		result = prime * result + ((familyOfThisGpu == null) ? 0 : familyOfThisGpu.hashCode());
		result = prime * result + ((gpuSlotOfThisGpu == null) ? 0 : gpuSlotOfThisGpu.hashCode());
		result = prime * result
				+ ((maximumDirectXSupportedByThisGpu == null) ? 0 : maximumDirectXSupportedByThisGpu.hashCode());
		result = prime * result + ((memoryBandwidth == null) ? 0 : memoryBandwidth.hashCode());
		result = prime * result + ((memoryBus == null) ? 0 : memoryBus.hashCode());
		result = prime * result + ((memorySize == null) ? 0 : memorySize.hashCode());
		result = prime * result + ((memorySpeed == null) ? 0 : memorySpeed.hashCode());
		result = prime * result + ((memoryTechnologyOfThisGpu == null) ? 0 : memoryTechnologyOfThisGpu.hashCode());
		result = prime * result + ((openGL == null) ? 0 : openGL.hashCode());
		result = prime * result + ((pixelRate == null) ? 0 : pixelRate.hashCode());
		result = prime * result + ((rayTracingCores == null) ? 0 : rayTracingCores.hashCode());
		result = prime * result + ((rop == null) ? 0 : rop.hashCode());
		result = prime * result + ((shader == null) ? 0 : shader.hashCode());
		result = prime * result + ((shaderProcessingUnits == null) ? 0 : shaderProcessingUnits.hashCode());
		result = prime * result + ((tdp == null) ? 0 : tdp.hashCode());
		result = prime * result + ((tensorCores == null) ? 0 : tensorCores.hashCode());
		result = prime * result + ((textureRate == null) ? 0 : textureRate.hashCode());
		result = prime * result + ((tmu == null) ? 0 : tmu.hashCode());
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
		GpuDTO other = (GpuDTO) obj;
		if (architectureOfThisGpu == null) {
			if (other.architectureOfThisGpu != null)
				return false;
		} else if (!architectureOfThisGpu.equals(other.architectureOfThisGpu))
			return false;
		if (boostClock == null) {
			if (other.boostClock != null)
				return false;
		} else if (!boostClock.equals(other.boostClock))
			return false;
		if (cache == null) {
			if (other.cache != null)
				return false;
		} else if (!cache.equals(other.cache))
			return false;
		if (coreSpeed == null) {
			if (other.coreSpeed != null)
				return false;
		} else if (!coreSpeed.equals(other.coreSpeed))
			return false;
		if (cpuRecommendedForThisGpu == null) {
			if (other.cpuRecommendedForThisGpu != null)
				return false;
		} else if (!cpuRecommendedForThisGpu.equals(other.cpuRecommendedForThisGpu))
			return false;
		if (driverSupport == null) {
			if (other.driverSupport != null)
				return false;
		} else if (!driverSupport.equals(other.driverSupport))
			return false;
		if (familyOfThisGpu == null) {
			if (other.familyOfThisGpu != null)
				return false;
		} else if (!familyOfThisGpu.equals(other.familyOfThisGpu))
			return false;
		if (gpuSlotOfThisGpu == null) {
			if (other.gpuSlotOfThisGpu != null)
				return false;
		} else if (!gpuSlotOfThisGpu.equals(other.gpuSlotOfThisGpu))
			return false;
		if (maximumDirectXSupportedByThisGpu == null) {
			if (other.maximumDirectXSupportedByThisGpu != null)
				return false;
		} else if (!maximumDirectXSupportedByThisGpu.equals(other.maximumDirectXSupportedByThisGpu))
			return false;
		if (memoryBandwidth == null) {
			if (other.memoryBandwidth != null)
				return false;
		} else if (!memoryBandwidth.equals(other.memoryBandwidth))
			return false;
		if (memoryBus == null) {
			if (other.memoryBus != null)
				return false;
		} else if (!memoryBus.equals(other.memoryBus))
			return false;
		if (memorySize == null) {
			if (other.memorySize != null)
				return false;
		} else if (!memorySize.equals(other.memorySize))
			return false;
		if (memorySpeed == null) {
			if (other.memorySpeed != null)
				return false;
		} else if (!memorySpeed.equals(other.memorySpeed))
			return false;
		if (memoryTechnologyOfThisGpu == null) {
			if (other.memoryTechnologyOfThisGpu != null)
				return false;
		} else if (!memoryTechnologyOfThisGpu.equals(other.memoryTechnologyOfThisGpu))
			return false;
		if (openGL == null) {
			if (other.openGL != null)
				return false;
		} else if (!openGL.equals(other.openGL))
			return false;
		if (pixelRate == null) {
			if (other.pixelRate != null)
				return false;
		} else if (!pixelRate.equals(other.pixelRate))
			return false;
		if (rayTracingCores == null) {
			if (other.rayTracingCores != null)
				return false;
		} else if (!rayTracingCores.equals(other.rayTracingCores))
			return false;
		if (rop == null) {
			if (other.rop != null)
				return false;
		} else if (!rop.equals(other.rop))
			return false;
		if (shader == null) {
			if (other.shader != null)
				return false;
		} else if (!shader.equals(other.shader))
			return false;
		if (shaderProcessingUnits == null) {
			if (other.shaderProcessingUnits != null)
				return false;
		} else if (!shaderProcessingUnits.equals(other.shaderProcessingUnits))
			return false;
		if (tdp == null) {
			if (other.tdp != null)
				return false;
		} else if (!tdp.equals(other.tdp))
			return false;
		if (tensorCores == null) {
			if (other.tensorCores != null)
				return false;
		} else if (!tensorCores.equals(other.tensorCores))
			return false;
		if (textureRate == null) {
			if (other.textureRate != null)
				return false;
		} else if (!textureRate.equals(other.textureRate))
			return false;
		if (tmu == null) {
			if (other.tmu != null)
				return false;
		} else if (!tmu.equals(other.tmu))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GpuDTO [tmu=" + tmu + ", textureRate=" + textureRate + ", rop=" + rop + ", pixelRate=" + pixelRate
				+ ", shaderProcessingUnits=" + shaderProcessingUnits + ", rayTracingCores=" + rayTracingCores
				+ ", tensorCores=" + tensorCores + ", driverSupport=" + driverSupport + ", memorySize=" + memorySize
				+ ", memorySpeed=" + memorySpeed + ", memoryBus=" + memoryBus + ", memoryBandwidth=" + memoryBandwidth
				+ ", cache=" + cache + ", coreSpeed=" + coreSpeed + ", boostClock=" + boostClock + ", tdp=" + tdp
				+ ", shader=" + shader + ", openGL=" + openGL + ", familyOfThisGpu=" + familyOfThisGpu
				+ ", architectureOfThisGpu=" + architectureOfThisGpu + ", memoryTechnologyOfThisGpu="
				+ memoryTechnologyOfThisGpu + ", maximumDirectXSupportedByThisGpu=" + maximumDirectXSupportedByThisGpu
				+ ", gpuSlotOfThisGpu=" + gpuSlotOfThisGpu + ", cpuRecommendedForThisGpu=" + cpuRecommendedForThisGpu
				+ "]";
	}

	
	
}
