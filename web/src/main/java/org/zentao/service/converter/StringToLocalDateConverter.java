package org.zentao.service.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

  private static final DateTimeFormatter YYMMDD = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @Override
  public LocalDate convert(String source) {
    if (StringUtils.isBlank(source)) {
      return null;
    }
    return LocalDate.parse(source, YYMMDD);
  }
}
