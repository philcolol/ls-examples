package ls.example.service.workspace;

import org.eclipse.lsp4j.*;
import org.eclipse.lsp4j.services.WorkspaceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class StubWorkspaceService implements WorkspaceService
{
    @Override
    public CompletableFuture<List<? extends SymbolInformation>> symbol(WorkspaceSymbolParams workspaceSymbolParams)
    {
        return null;
    }

    @Override
    public void didChangeConfiguration(DidChangeConfigurationParams didChangeConfigurationParams)
    {
    }

    @Override
    public void didChangeWatchedFiles(DidChangeWatchedFilesParams didChangeWatchedFilesParams)
    {
    }
}
