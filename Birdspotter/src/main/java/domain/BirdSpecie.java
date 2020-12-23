package domain;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

public class BirdSpecie {
	
	@NotEmpty(message = "This input may not be empty")
	private String name;
	
//	@Pattern(regexp = "^(0|[1-9][0-9]*)$", message = "The year may only contain digits" )
	@Min(value = 1250, message = "The earliest year of discovery is 1250")
	@NotNull(message = "This input may not be empty")
	@NumberFormat(style = Style.DEFAULT)
    private Integer yearOfDiscovery;	
	
	@Pattern(regexp = "[A-Z]{1,2}[0-9]{3}", message = "Code should start with one or two capital letters [A-Z] followed by 3 digits")
	@NotEmpty(message = "This input may not be empty")
    private String code;
		
	public BirdSpecie(String name, Integer yearOfDiscovery, String code) {
		super();
		this.name = name;
		this.yearOfDiscovery = yearOfDiscovery;
		this.code = code;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getYearOfDiscovery() {
		return yearOfDiscovery;
	}

	public void setYearOfDiscovery(Integer yearOfDiscovery) {
		this.yearOfDiscovery = yearOfDiscovery;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return String.format("%s - %d (%s)", getName(), getYearOfDiscovery(), getCode());
	}
	
	   @Override

       public boolean equals(Object obj) {

                      if (this == obj)

                                    return true;

                      if (obj == null || getClass() != obj.getClass())

                                    return false;

                      BirdSpecie other = (BirdSpecie) obj;

                      if (!code.equals(other.code))

                                    return false;

                      return name.equalsIgnoreCase(other.name);

       }
	
}
