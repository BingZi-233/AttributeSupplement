package vip.bingzi.attributesupplement.util

import io.izzel.taboolib.module.locale.TLocale
import vip.bingzi.attributesupplement.util.AttributeSupplementUtil.logger

/**
 * 杂物堆
 *
 * @author 冰上云梦
 * @since 2021-02-15 19:00
 */
object TalentSundries {
    // 用于输出等级样式
    fun previewLogger() {
        logger.verbose(TLocale.asString("Command.logger.VERBOSE"))
        logger.finest(TLocale.asString("Command.logger.FINEST"))
        logger.fine(TLocale.asString("Command.logger.FINE"))
        logger.info(TLocale.asString("Command.logger.INFO"))
        logger.warn(TLocale.asString("Command.logger.WARN"))
        logger.error(TLocale.asString("Command.logger.ERROR"))
        logger.fatal(TLocale.asString("Command.logger.FATAL"))
    }
}