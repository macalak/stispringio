package ite.librarymaster.web.validator;

import ite.librarymaster.model.Book;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BookValidator implements Validator{
	private static final int AUTHOR_MIN_LENGHT=3; 

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Book.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "author", "BookValidator.author.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "BookValidator.title.required");
		Book book = (Book) target;
		if(book.getAuthor().length() < AUTHOR_MIN_LENGHT){
			errors.rejectValue("author", "BookValidator.author.min",new Object[]{AUTHOR_MIN_LENGHT},"Author must have min "+ AUTHOR_MIN_LENGHT +" characters");
		}
	}
}
