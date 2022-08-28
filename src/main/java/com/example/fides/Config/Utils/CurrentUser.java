package com.example.fides.Config.Utils;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import java.lang.annotation.*;

@Documented
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@AuthenticationPrincipal
public @interface CurrentUser {




}
