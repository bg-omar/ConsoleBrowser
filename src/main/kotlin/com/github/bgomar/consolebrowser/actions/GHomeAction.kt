package com.github.bgomar.consolebrowser.actions

import com.github.bgomar.consolebrowser.services.GivServiceSettings
import com.intellij.openapi.actionSystem.ActionUpdateThread
import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.project.DumbAware
import com.intellij.ui.jcef.JBCefBrowser
import javax.swing.Icon

class GHomeAction(private val jbCefBrowser: JBCefBrowser, icon: Icon) : AnAction(icon), DumbAware {


    override fun update(e: AnActionEvent) {
        e.presentation.isEnabled = true
    }

    override fun getActionUpdateThread() = ActionUpdateThread.EDT

    override fun actionPerformed(e: AnActionEvent) {
        jbCefBrowser.loadURL(GivServiceSettings.instance().getLastSaveHomePage())
    }
}
