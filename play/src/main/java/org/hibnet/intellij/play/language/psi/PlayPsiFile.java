package org.hibnet.intellij.play.language.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import org.hibnet.intellij.play.language.PlayFileType;
import org.hibnet.intellij.play.language.PlayLanguage;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class PlayPsiFile extends PsiFileBase {
  public PlayPsiFile(FileViewProvider viewProvider) {
    super(viewProvider, PlayLanguage.INSTANCE);
  }

  @Override
  @NotNull
  public FileType getFileType() {
    return PlayFileType.INSTANCE;
  }

  @NotNull
  public String getPresentableName() {
    return getName();
  }

  @Override
  public String toString() {
    return "PlayPsiFile: " + getPresentableName();
  }

  public PlayTag @NotNull [] getRootTags() {
    return findChildrenByClass(PlayTag.class);
  }
}

