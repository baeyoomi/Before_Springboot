package com.example.demo.validator;

import com.example.demo.form.CalcForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

//@Controller(MVC 제어) @Service(도메인서비스) @Repository(DB) @Component(Etc)
@Component
public class CalcValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        //인수로 전달받은 Form이 입력 체크의 대상인지를 논리값으로 돌려준다.
        return CalcForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CalcForm form = (CalcForm) target;
        //맞는경우(왼쪽은 홀수, 오른쪽은 짝수)
        if(form.getLeftNum() != null && form.getRightNum() != null){
            if(!((form.getLeftNum() % 2 == 1) && (form.getRightNum() % 2 ==0))){
                errors.reject("com.example.demo.validator.CalcValidator.message");
            }
        }
    }
}
