package ingdani.com.co.web;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

public class WebConfig implements WebMvcConfigurer {
    @Bean
    public LocaleResolver localeResolver(){
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(new Locale("ar"));
     return slr;
    }

    //Configuramos un interceptor para cambiar de forma dinamina
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor(){
         var lci = new LocaleChangeInterceptor();
         lci.setParamName("lang");
        return lci;
    }
    //Sobre-escribimos el metodo de interceptor
    public void addInterceptor(InterceptorRegistry registro){
        registro.addInterceptor(localeChangeInterceptor());
    }
}
