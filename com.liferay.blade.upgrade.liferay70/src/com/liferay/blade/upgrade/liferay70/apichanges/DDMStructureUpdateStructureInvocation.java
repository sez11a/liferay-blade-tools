package com.liferay.blade.upgrade.liferay70.apichanges;

import com.liferay.blade.api.FileMigrator;
import com.liferay.blade.api.JavaFile;
import com.liferay.blade.api.SearchResult;
import com.liferay.blade.upgrade.liferay70.JavaFileMigrator;

import java.io.File;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
	property = {
		"file.extensions=java,jsp,jspf",
		"problem.summary=Added userId Parameter to Update Operations of DDMStructureLocalService and DDMTemplateLocalService",
		"problem.tickets=LPS-50939",
		"problem.title=DDMStructureLocalService add new param userId",
		"problem.section=#added-userid-parameter-to-update-operations-of-ddmstructurelocalservice-and-ddmtemplatelocalservice",
	},
	service = FileMigrator.class
)
public class DDMStructureUpdateStructureInvocation extends JavaFileMigrator {

	@Override
	protected List<SearchResult> searchFile(File file, JavaFile javaFileChecker) {
		return javaFileChecker.findMethodInvocations(null, "DDMStructureLocalServiceUtil", "updateStructure", null);
	}

}
