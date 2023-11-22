package com.github.bgomar.consolebrowser.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil
import org.jetbrains.annotations.Nullable




@State(name = "ConsoleBrowserSettings", storages = [(Storage("consolebrowsersettings.xml"))])
class ConsoleBrowserSettings : PersistentStateComponent<ConsoleBrowserSettings> {



  var version = System.getenv("CONSOLEBROWSER_VERSION")

  companion object {
    val instance: ConsoleBrowserSettings
      get() = ApplicationManager.getApplication().getService(ConsoleBrowserSettings::class.java)
  }

  @Nullable
  override fun getState(): ConsoleBrowserSettings = this

  override fun loadState(state: ConsoleBrowserSettings) {
    XmlSerializerUtil.copyBean(state, this)
  }
}
