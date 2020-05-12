package br.ipen.cestoque.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.ipen.cestoque.dto.FornecedorNewDTO;
import br.ipen.cestoque.resources.exception.FieldMessage;
import br.ipen.cestoque.services.validation.utils.BR;

public class FornecedorInsertValidator implements ConstraintValidator<FornecedorInsert, FornecedorNewDTO> {

	@Override
	public void initialize(FornecedorInsert constraintAnnotation) {

	}

	@Override
	public boolean isValid(FornecedorNewDTO value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		List<FieldMessage> list = new ArrayList<>();

		if(!BR.isValidCNPJ(value.getCnpj())) {
			list.add(new FieldMessage("cnpj", "CNPJ inválido"));
		}
		
		for (FieldMessage f : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}

}
