package be.vdab.ondernemingsnummer.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import static org.assertj.core.api.Assertions.assertThat;

public class FirmaTest {
    private Validator validator;
    private Firma firma;
    @BeforeEach void beforeEach(){
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        firma=new Firma();
    }
    @Test void correctOndernemingsNummer(){
        firma.setOndernemingsNummer(426388541);
        assertThat(validator.validate(firma)).isEmpty();
    }
    @Test void verkeerdOndernemingsNummer(){
        firma.setOndernemingsNummer(426388540);
        assertThat(validator.validate(firma)).isNotEmpty();
    }
}
