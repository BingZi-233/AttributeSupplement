package vip.bingzi.attributesupplement

import io.izzel.taboolib.loader.Plugin
import io.izzel.taboolib.module.config.TConfig
import io.izzel.taboolib.module.inject.TInject
import io.izzel.taboolib.module.locale.logger.TLogger
import vip.bingzi.attributesupplement.util.AttributeSupplementUtil.logger

object AttributeSupplement : Plugin() {
    // 配置文件
    @TInject(value = ["setting.yml"], locale = "LOCALE-PRIORITY")
    lateinit var setting: TConfig
        private set

    override fun onLoad() {

    }

    override fun onEnable() {
        // 设置日志输出等级
        logger.level = when (setting.getString("Settings.Logger")) {
            "VERBOSE" -> TLogger.VERBOSE
            "FINEST" -> TLogger.FINEST
            "FINE" -> TLogger.FINE
            "INFO" -> TLogger.INFO
            "WARN" -> TLogger.WARN
            "ERROR" -> TLogger.ERROR
            "FATAL" -> TLogger.FATAL
            else -> TLogger.INFO
        }
    }

    override fun onDisable() {

    }
}