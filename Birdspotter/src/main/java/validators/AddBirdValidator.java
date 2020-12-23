package validators;

import java.time.Year;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import domain.BirdSpecie;

public class AddBirdValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return BirdSpecie.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		BirdSpecie specie = (BirdSpecie) target;

		Integer year = specie.getYearOfDiscovery();

//		String code = specie.getCode();

//		if(!Pattern.matches("[0-9]*", year.toString())) {
//			errors.rejectValue("yearOfDiscovery", "badRequest" ,"The year may only contain digits");			
//		}
		if (year == null) {
			return;
		}

		if (year > Year.now().getValue())
			errors.rejectValue("yearOfDiscovery", "badRequest", "You cannot discover birds in the future!");

	}

}
