package com.github.bgomar.consolebrowser.settings

import com.intellij.openapi.options.SearchableConfigurable
import javax.swing.JComponent

class ProjectSettingsConfigurable : SearchableConfigurable {

    private var projectSettingsComponent: ProjectSettingsComponent? = null

    override fun createComponent(): JComponent {

        projectSettingsComponent = ProjectSettingsComponent()
        return projectSettingsComponent!!.getPanel()
    }

    override fun getPreferredFocusedComponent(): JComponent {
        return projectSettingsComponent!!.getPreferredFocusedComponent()
    }

    override fun isModified(): Boolean {
        return projectSettingsComponent!!.isModified()
    }

    override fun apply() {
        projectSettingsComponent!!.apply()
    }

    override fun reset() {
        projectSettingsComponent!!.reset()

    }

    override fun getDisplayName(): String {
        return "ConsoleBrowser"
    }

    override fun getId(): String {
        return "com.github.bgomar.consolebrowser.settings.ProjectSettingsConfigurable"
    }

    override fun disposeUIResources() {
        projectSettingsComponent = null
    }

}
