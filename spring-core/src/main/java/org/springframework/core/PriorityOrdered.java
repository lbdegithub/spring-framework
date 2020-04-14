/*
 * Copyright 2002-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core;

/**
 * 扩展了Ordered接口，表示优先顺序：PriorityOrdered对象始终在普通Ordered对象之前应用，而不管其顺序值如何。
 * 在对一组有序对象进行排序时，PriorityOrdered对象和普通Ordered对象被有效地视为两个单独的子集，
 * 其中PriorityOrdered对象组位于普通Ordered对象集之前，并且在这些子集中应用了相对顺序。
 * 这主要是一个特殊用途的接口，在框架本身内用于对象，在该对象中，首先识别优先对象非常重要，
 * 甚至可能在没有获得其余对象的情况下也是如此。一个典型的示例：在Spring org.springframework.context.ApplicationContext中优先处理后处理器。
 * 注意：PriorityOrdered后处理器Bean在特殊阶段中比其他后处理器Bean初始化。
 * 这巧妙地影响了它们的自动装配行为：它们将仅与不需要为类型匹配而急切初始化的bean自动装配在一起
 * Extension of the {@link Ordered} interface, expressing a <em>priority</em>
 * ordering: {@code PriorityOrdered} objects are always applied before
 * <em>plain</em> {@link Ordered} objects regardless of their order values.
 *
 * <p>When sorting a set of {@code Ordered} objects, {@code PriorityOrdered}
 * objects and <em>plain</em> {@code Ordered} objects are effectively treated as
 * two separate subsets, with the set of {@code PriorityOrdered} objects preceding
 * the set of <em>plain</em> {@code Ordered} objects and with relative
 * ordering applied within those subsets.
 *
 * <p>This is primarily a special-purpose interface, used within the framework
 * itself for objects where it is particularly important to recognize
 * <em>prioritized</em> objects first, potentially without even obtaining the
 * remaining objects. A typical example: prioritized post-processors in a Spring
 * {@link org.springframework.context.ApplicationContext}.
 *
 * <p>Note: {@code PriorityOrdered} post-processor beans are initialized in
 * a special phase, ahead of other post-processor beans. This subtly
 * affects their autowiring behavior: they will only be autowired against
 * beans which do not require eager initialization for type matching.
 *
 * @author Juergen Hoeller
 * @author Sam Brannen
 * @since 2.5
 * @see org.springframework.beans.factory.config.PropertyOverrideConfigurer
 * @see org.springframework.beans.factory.config.PropertyPlaceholderConfigurer
 */
public interface PriorityOrdered extends Ordered {
}
