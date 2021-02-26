package vip.bingzi.attributesupplement.util

import io.izzel.taboolib.module.command.base.*
import io.izzel.taboolib.module.locale.TLocale
import io.izzel.taboolib.module.locale.logger.TLogger
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import vip.bingzi.attributesupplement.AttributeSupplement
import vip.bingzi.attributesupplement.util.AttributeSupplementUtil.logger
import vip.bingzi.attributesupplement.util.TalentSundries.previewLogger

/**
 * 命令
 *
 * @author 冰上云梦
 * @since 2021-02-15 19:00
 */
@BaseCommand(name = "attributesupplement", aliases = ["as"], permission = "attributesupplement.use")
class AttributeSupplementCommand : BaseMainCommand() {
    @SubCommand
    var adminUtil: BaseSubCommand = object : BaseSubCommand() {
        override fun getPermission(): String {
            return "attributesupplement.admin"
        }

        override fun getDescription(): String {
            return "管理员工具"
        }

        override fun getArguments(): Array<Argument> {
            return arrayOf(
                Argument("debug(调试)/logger(日志-需要参数等级)/reload(重启配置流程)") {
                    listOf(
                        "debug",
                        "logger",
                        "reload",
                    )
                },
                Argument("等级(默认为INFO)", false) { listOf("VERBOSE", "FINEST", "FINE", "INFO", "WARN", "ERROR", "FATAL") }
            )
        }

        override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>) {
            if (sender is Player) {
                return
            }
            when (args[0]) {
                "debug" -> {
                    // 设置日志输出等级
                    logger.level = TLogger.FINEST
                    if (AttributeSupplement.setting.getBoolean("Style.ExampleLogger")) previewLogger()
                }
                "logger" -> {
                    // 设置日志输出等级
                    logger.level = when (args[1]) {
                        "VERBOSE" -> TLogger.VERBOSE
                        "FINEST" -> TLogger.FINEST
                        "FINE" -> TLogger.FINE
                        "INFO" -> TLogger.INFO
                        "WARN" -> TLogger.WARN
                        "ERROR" -> TLogger.ERROR
                        "FATAL" -> TLogger.FATAL
                        else -> TLogger.INFO
                    }
                    if (AttributeSupplement.setting.getBoolean("Style.ExampleLogger")) previewLogger()
                }
                else -> {
                    logger.warn(TLocale.asString("Command.Warn.CommandParameterError"))
                }
            }
        }
    }
}