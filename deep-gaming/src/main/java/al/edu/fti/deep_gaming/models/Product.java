package al.edu.fti.deep_gaming.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "product")
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product", nullable = false)
	private Integer idProduct;

	@Column(name = "product_name", nullable = false, length = 100)
	private String productName;

	@Column(name = "product_description", nullable = false, length = 65535)
	private String productDescription;

	@Column(name = "release_date", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date releaseDate;

	@Column(name = "price")
	private Integer price;

	@Column(name = "quantity")
	private Integer quantity;

	@Column(name = "upload_date", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date uploadDate;

	@Column(name = "edited_date", nullable = false, columnDefinition = "DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date editedDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "suggested_by")
	private User suggestedBy;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "approved_by")
	private User approvedBy;

	@Column(name = "hyperlink", nullable = false, length = 255)
	private String hyperlink;
}
