package eu.musicnova.musicnova.utils

object Const {
    const val ROOT_BYPASS_FLAG = "--imRunningAsRootItIsEvilAndIKnowIt"
    const val DISABLE_SENTRY_FLAG = "--disable-sentry"

    const val MN_PROPERTY_PREFIX = "musicnova"
    const val INTERACTIVE_PROPERTY = "terminal.enabled"
    const val INTERACTIVE_PROPERTY_FULL_NAME = "$MN_PROPERTY_PREFIX.$INTERACTIVE_PROPERTY"

    const val BEAN_IS_BOOT_JAR = "is-boot-jar"
    const val BEAN_DATA_FOLDER = "data_folder"
    const val BEAN_TEMP_FOLDER = "temp_folder"
    const val BEAN_AUDIO_TRACK_FOLDER = "audio_track"
    const val BEAN_NAME_CLI_PRESENT = "init_cli_present"

    const val BEAN_EXEC_ASYNC_EVENT = "exec_async_event"

}