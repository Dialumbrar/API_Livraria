package br.senac.sp.livraria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// Captura e centraliza as exceções disparadas por qualquer Controller da aplicação
@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura especificamente falhas disparadas pela validação do @Valid
    @SuppressWarnings("unused")
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        // Mapeia cada campo inválido diretamente à sua respectiva mensagem de erro configurada na Model
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        // Retorna o mapa gerado com a resposta HTTP 400 Bad Request (removido estrangeirismo do comentário)
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
