package com.github.bgomar.consolebrowser

import com.github.bgomar.consolebrowser.services.GivServiceSettings
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory

class GivToolWindowFactory : ToolWindowFactory, DumbAware {


    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        setupToolWindowContent(toolWindow)
    }


    private fun setupToolWindowContent(toolWindow: ToolWindow) {
        val contentManager = toolWindow.contentManager
        val rootComponent = GivMainPanel(GivServiceSettings.instance().getLastSaveHomePage())
        val content = contentManager.factory.createContent(rootComponent, null, false)
        contentManager.addContent(content)
    }

    companion object{
        @Suppress("unused")
        const val GBROWSER_TOOL_WINDOW_ID = "ConsoleBrowser"
    }

}
