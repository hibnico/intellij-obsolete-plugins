/*
 * Copyright 2000-2011 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.hibnet.intellij.play.utils;

import com.intellij.psi.*;
import com.intellij.psi.search.LocalSearchScope;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.search.UseScopeEnlarger;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

public class PlayScopeEnlarger extends UseScopeEnlarger {
  @Override
  public SearchScope getAdditionalUseScope(@NotNull PsiElement element) {
    if (element instanceof PsiParameter) {
      final PsiMethod method = PsiTreeUtil.getParentOfType(element, PsiMethod.class);
      if (method != null) {
        final PsiFile view = PlayPathUtils.getCorrespondingView(method);
        if (view != null) {
          return new LocalSearchScope(view);
        }
      }
    }
    return null;
  }


}
