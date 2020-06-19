package br.ipen.cestoque.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.dto.ColaboradorNewDTO;
import br.ipen.cestoque.repositories.ColaboradorRepository;
import br.ipen.cestoque.resources.exception.FieldMessage;
import br.ipen.cestoque.services.validation.utils.BR;

public class ColaboradorInsertValidator implements ConstraintValidator<ColaboradorInsert, ColaboradorNewDTO> {

	@Autowired
	private ColaboradorRepository repo;
	
	@Override
	public void initialize(ColaboradorInsert constraintAnnotation) {

	}
	

	@Override
	public boolean isValid(ColaboradorNewDTO value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		List<FieldMessage> list = new ArrayList<>();

		if(!BR.isValidCPF(value.getCpf())) {
			list.add(new FieldMessage("cpf", "CPF inválido"));
		}
		
		Colaborador aux = repo.findByEmail(value.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage f : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(f.getMessage()).addPropertyNode(f.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();
	}

}
