package org.hibnet.intellij.play.references;

import com.intellij.openapi.util.Key;
import org.hibnet.intellij.play.PlayIcons;
import com.intellij.psi.*;
import com.intellij.psi.impl.RenameableFakePsiElement;
import com.intellij.util.IncorrectOperationException;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class PlayFakeRenameableReferenceProvider extends PsiReferenceProvider {
  public static final Key<RenameableFakePsiElement> RENAMEABLE_FAKE_PSI_ELEMENT_KEY = Key.create("PlayExpressionSelfReference");

  @Override
  public PsiReference @NotNull [] getReferencesByElement(@NotNull final PsiElement element, @NotNull ProcessingContext context) {

    if (element instanceof PsiLiteralValue) {
      return new PsiReference[]{new PsiReferenceBase<>((PsiLiteralValue)element) {
        @Override
        public PsiElement resolve() {
          return getOrCreateRenamebaleFakeElement((PsiLiteralValue)element);
        }
      }};
    }
    return PsiReference.EMPTY_ARRAY;
  }

  public static RenameableFakePsiElement getOrCreateRenamebaleFakeElement(@NotNull final PsiLiteralValue expression) {
    RenameableFakePsiElement data = expression.getUserData(RENAMEABLE_FAKE_PSI_ELEMENT_KEY);
    if (data == null) {
      data = createRenamebaleFakeElement(expression);
      expression.putUserData(RENAMEABLE_FAKE_PSI_ELEMENT_KEY, data);
    }
    return data;
  }

  public static RenameableFakePsiElement createRenamebaleFakeElement(@NotNull final PsiLiteralValue expression) {
    return new RenameableFakePsiElement(expression) {
      @Override
      public String getName() {
        return ElementManipulators.getValueText(expression);
      }

      @Override
      public PsiElement getParent() {
        return expression;
      }

      @Override
      public PsiElement setName(@NonNls @NotNull String name) throws IncorrectOperationException {
        return super.setName(name);
      }

      @NotNull
      @Override
      public PsiElement getNavigationElement() {
        return expression;
      }

      @Override @NonNls
      public String getTypeName() {
        return "Variable";
      }

      @Override
      public Icon getIcon() {
        return PlayIcons.Play;
      }
    };
  }
}
