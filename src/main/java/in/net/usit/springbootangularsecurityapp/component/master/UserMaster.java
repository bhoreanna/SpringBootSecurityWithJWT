package in.net.usit.springbootangularsecurityapp.component.master;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity

@Table(name="User_Master")
@Data
@Setter
@Getter


public class UserMaster implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private BigDecimal userUid;
	
	private String userId ;
	private String userName;
	private String createdBy  ;
	private String modifiedBy   ;
	private Date createdDate ;
	private Date modifyDate  ;
	private String userStatus ;
	private String password  ;
	private String email    ; 
	
	@JoinColumn(name = "roleUid")
    @OneToOne()
	private RoleMaster roleMaster ;



	


}
