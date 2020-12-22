package domain;

import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

public class BirdSpecie {
	
	@NotEmpty
	private String name;
	
	@DateTimeFormat(pattern = "yyyy")
    private Integer yearOfDiscovery;
	
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
