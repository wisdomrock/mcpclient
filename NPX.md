For the MCP Server to get started successfully, Node JS must be installed globally, verifiable by
  node --version
  npx -version

# NPX (Node Package eXecutor)
## npx is a command-line tool bundled with npm (since version 5.2.0) that lets you run Node.js package executables without globally installing them first
spring.ai.mcp.client.stdio.servers-configuration will start a local MCP Server, e.g. Filesystem MCP Server.

# To pass a folder path using a variable name in your MCP server npx arguments
Using ${env:WORKING_FOLDER} Syntax and set WORKING_FOLDER=. when program starts
Paths containing spaces on Windows sometimes cause issues with argument parsing.
If this occurs, you might need to wrap the variable in double quotes within the args array (e.g., "${env:MY_FOLDER_PATH}")

Some clients provide built-in variables for common paths that you can use in your args field (Allowed directories):
- ${env:HOMEPATH}: Path to the user's home folder.

Debug StdioClientTransport.StdioClientTransport(ServerParameters params, McpJsonMapper jsonMapper) to inspect params which contains env variable HOMEPATH

# To pass a folder path using a variable name in your MCP server npx arguments
Using ${env:WORKING_FOLDER} Syntax and set WORKING_FOLDER=. when program starts
Paths containing spaces on Windows sometimes cause issues with argument parsing. 
If this occurs, you might need to wrap the variable in double quotes within the args array (e.g., "${env:MY_FOLDER_PATH}")

Some clients provide built-in variables for common paths that you can use in your args field (Allowed directories):
- ${env:HOMEPATH}: Path to the user's home folder.
- ${workspaceFolder}: Path to the project root. 

We can always use relative path, e.g. "./mcp-data"

Caused by: java.io.IOException: Cannot run program "npx": CreateProcess error=2, The system cannot find the file specified
at io.modelcontextprotocol.client.transport.StdioClientTransport.lambda$connect$1(StdioClientTransport.java:121)
Caused by: java.io.IOException: CreateProcess error=2, The system cannot find the file specified

# run the npx  command line directly
npx -y @modelcontextprotocol/server-filesystem C:\Users\wisdo\ai-test\mcp-data
## Secure MCP Filesystem Server running on stdio

## Make sure Java environment variable include PATH which also contain paths to nodejs executable: D:\MyPrograms\nodejs

Or even config "command" with absolute path to npx executable: "command": "D:\\MyPrograms\\nodejs\\npx"
However npx is not a valid Win32 program, on Windows we must config "command": "npx.cmd"

## Send messages to LLM
Who are you and how can you help me?
create a file named hello.txt in your current working directory with content 'Hello World'
