package org.zentao.util;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.PropertyUtils;

public abstract class BeanUtil {

  private BeanUtil() {
  }

  public static final void copyPropsExcludeNull(Object dest, Object from, String... props)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    if (null == props || 1 > props.length) {
      PropertyUtils.copyProperties(dest, from);
      return;
    }

    for (String prop : props) {
      Object value = PropertyUtils.getNestedProperty(from, prop);
      if (null != value) {
        PropertyUtils.setNestedProperty(dest, prop, value);
      }
    }

  }
}
