package com.marklogic.gradle.task

import com.marklogic.appdeployer.command.ResourceFileManagerImpl
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * As opposed to DeleteModuleTimestampsFileTask, this task doesn't look for a file path in the
 * AppConfig object, as ml-app-deployer doesn't support that yet (it's a little tricky to implement).
 * So this is hardcoded to the default path defined by ResourceFileManagerImpl.
 */
class DeleteResourceTimestampsFileTask extends DefaultTask {

	@TaskAction
	void deleteResourceTimestampsFile() {
		File f = new File(ResourceFileManagerImpl.DEFAULT_FILE_PATH)
		if (f.exists()) {
			println "Deleting " + f.getAbsolutePath() + "\n"
			f.delete()
		} else {
			println "Resource timestamps file " + filePath + " does not exist, so not deleting"
		}
	}
}
