/*
 * Copyright 2000-2009 JetBrains s.r.o.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.hibnet.intellij.play.language.groovy;

import com.intellij.lang.ASTNode;
import org.hibnet.intellij.play.language.PlayCompositeElementType;
import com.intellij.psi.templateLanguages.OuterLanguageElementImpl;
import com.intellij.psi.tree.ILeafElementType;
import org.jetbrains.annotations.NotNull;

public class PlayGroovyOuterElementType extends PlayCompositeElementType implements ILeafElementType {

  public PlayGroovyOuterElementType() {
    super("GROOVY_OUTER_ELEMENT");
  }

  @Override
  @NotNull
  public ASTNode createLeafNode(CharSequence leafText) {
    return new OuterLanguageElementImpl(this, leafText);
  }
}
