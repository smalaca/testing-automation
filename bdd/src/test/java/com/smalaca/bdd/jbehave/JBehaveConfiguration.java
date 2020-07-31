package com.smalaca.bdd.jbehave;

import org.jbehave.core.Embeddable;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.i18n.LocalizedKeywords;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.model.ExamplesTableFactory;
import org.jbehave.core.model.TableParsers;
import org.jbehave.core.model.TableTransformers;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.jbehave.core.steps.ParameterControls;
import org.jbehave.core.steps.ParameterConverters;

import static org.jbehave.core.reporters.Format.CONSOLE;

public abstract class JBehaveConfiguration extends JUnitStory {
    @Override
    public Embedder configuredEmbedder() {
        Embedder embedder = super.configuredEmbedder();

        embedder.embedderControls()
                .doFailOnStoryTimeout(true)
                .useStoryTimeoutInSecs(60)
                .doGenerateViewAfterStories(false)
                .doIgnoreFailureInStories(false);

        return embedder;
    }

    @Override
    public Configuration configuration() {
        Class<? extends Embeddable> embeddableClass = this.getClass();
        ParameterConverters parameterConverters = new ParameterConverters();
        ExamplesTableFactory examplesTableFactory = new ExamplesTableFactory(
                new LocalizedKeywords(), new LoadFromClasspath(embeddableClass), parameterConverters, new ParameterControls(), new TableParsers(), new TableTransformers());
        parameterConverters.addConverters(
                new ParameterConverters.ExamplesTableConverter(examplesTableFactory),
                new ParameterConverters.EnumConverter(),
                new ParameterConverters.BooleanConverter("is", "is not"));

        return new MostUsefulConfiguration()
                .useParameterConverters(parameterConverters)
                .usePendingStepStrategy(new FailingUponPendingStep())
                .useStoryReporterBuilder(
                        new StoryReporterBuilder()
                                .withDefaultFormats()
                                .withFormats(CONSOLE));
    }

    @Override
    public InjectableStepsFactory stepsFactory() {
        return new InstanceStepsFactory(configuration(), this);
    }
}
