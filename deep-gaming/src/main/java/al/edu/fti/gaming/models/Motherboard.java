package al.edu.fti.gaming.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "motherboard")
public class Motherboard extends Product {

	private static final long serialVersionUID = 5258804225255359490L;

	@Column(name = "maximum_ram_capacity", nullable = false)
	private Double maximumRamCapacity;

	@Column(name = "maximum_ram_speed", nullable = false)
	private Integer maximumRamSpeed;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_company", nullable = false)
	private Company companyOfThisMotherboard;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_cpu_socket", nullable = false)
	private CpuSocket cpuSocketOfThisMotherboard;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_motherboard_form_factor", nullable = false)
	private MotherboardFormFactor formFactorOfThisMotherboard;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_gpu_slot", nullable = false)
	private GpuSlot gpuSlot;

	public Double getMaximumRamCapacity() {
		return maximumRamCapacity;
	}

	public void setMaximumRamCapacity(Double maximumRamCapacity) {
		this.maximumRamCapacity = maximumRamCapacity;
	}

	public Integer getMaximumRamSpeed() {
		return maximumRamSpeed;
	}

	public void setMaximumRamSpeed(Integer maximumRamSpeed) {
		this.maximumRamSpeed = maximumRamSpeed;
	}

	public Company getCompanyOfThisMotherboard() {
		return companyOfThisMotherboard;
	}

	public void setCompanyOfThisMotherboard(Company companyOfThisMotherboard) {
		this.companyOfThisMotherboard = companyOfThisMotherboard;
	}

	public CpuSocket getCpuSocketOfThisMotherboard() {
		return cpuSocketOfThisMotherboard;
	}

	public void setCpuSocketOfThisMotherboard(CpuSocket cpuSocketOfThisMotherboard) {
		this.cpuSocketOfThisMotherboard = cpuSocketOfThisMotherboard;
	}

	public MotherboardFormFactor getFormFactorOfThisMotherboard() {
		return formFactorOfThisMotherboard;
	}

	public void setFormFactorOfThisMotherboard(MotherboardFormFactor formFactorOfThisMotherboard) {
		this.formFactorOfThisMotherboard = formFactorOfThisMotherboard;
	}

	public GpuSlot getGpuSlot() {
		return gpuSlot;
	}

	public void setGpuSlot(GpuSlot gpuSlot) {
		this.gpuSlot = gpuSlot;
	}

}
